package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Questionnaire.QuestionnaireA01DTO;
import com.johnxb.questionnaire.dto.Questionnaire.QuestionnaireA01InputDTO;
import com.johnxb.questionnaire.dto.Questionnaire.QuestionnaireA02InputDTO;
import com.johnxb.questionnaire.entity.Question;
import com.johnxb.questionnaire.entity.Questionnaire;
import com.johnxb.questionnaire.service.ClassificationService;
import com.johnxb.questionnaire.service.ICurrentUser;
import com.johnxb.questionnaire.service.QuestionnaireService;
import com.johnxb.questionnaire.utils.BeanMapper;
import com.johnxb.questionnaire.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@Api(description = "问卷Api")
@RequestMapping("/Questionnaire")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    private final ICurrentUser currentUser;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService, ICurrentUser currentUser) {
        this.questionnaireService = questionnaireService;
        this.currentUser = currentUser;
    }

    @ApiOperation("获取分类问卷")
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid QuestionnaireA01InputDTO input) {
        JSONResult<List<QuestionnaireA01DTO>> jsonResult = new JSONResult<>();
        List<Questionnaire> questionnaireList = this.questionnaireService.getByParentId(input.getId());
        if( questionnaireList.size()==1&&null==questionnaireList.get(0)||questionnaireList.size()==0){
            jsonResult.setData(new ArrayList<>());
            return jsonResult;
        }
        List<QuestionnaireA01DTO> questionnaireA01DTOList = BeanMapper.mapList(questionnaireList, QuestionnaireA01DTO.class);
        jsonResult.setData(questionnaireA01DTOList);
        return jsonResult;
    }

    @ApiOperation("创建问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody QuestionnaireA02InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        if(!currentUser.isUser(input.getToken())){
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
        Questionnaire questionnaire = BeanMapper.map(input, Questionnaire.class);
        boolean success=questionnaireService.createQuestionnaire(questionnaire,currentUser.getUserId(input.getToken()));
        if(success){
            jsonResult.setMessage("创建问卷成功");
        }
        else jsonResult.setMessage("创建问卷失败,请检查您填写的信息");
        return jsonResult;
    }
}
