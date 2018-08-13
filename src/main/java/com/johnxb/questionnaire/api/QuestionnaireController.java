package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Questionnaire.*;
import com.johnxb.questionnaire.dto.RequestDTO;
import com.johnxb.questionnaire.entity.Question;
import com.johnxb.questionnaire.entity.Questionnaire;
import com.johnxb.questionnaire.entity.Record;
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
        if (questionnaireList.size() == 1 && null == questionnaireList.get(0) || questionnaireList.size() == 0) {
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
        if (!currentUser.isUser(input.getToken())) {
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
        Questionnaire questionnaire = BeanMapper.map(input, Questionnaire.class);
        boolean success = questionnaireService.createQuestionnaire(questionnaire, currentUser.getUserId(input.getToken()));
        if (success) {
            jsonResult.setMessage("创建问卷成功");
        } else jsonResult.setMessage("创建问卷失败,请检查您填写的信息");
        return jsonResult;
    }

    @ApiOperation("通过id查看问卷")
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid QuestionnaireIdInputDTO input) {
        JSONResult jsonResult = new JSONResult();
        Questionnaire questionnaire = questionnaireService.getQuestionnaireById(input.getId());
        QuestionnaireA03DTO questionnaireA03DTO = BeanMapper.map(questionnaire, QuestionnaireA03DTO.class);
        jsonResult.setData(questionnaireA03DTO);

        return jsonResult;
    }

    @ApiOperation("关闭问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid @RequestBody QuestionnaireA04InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        if (!currentUser.isUser(input.getToken())) {
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
       String message =  questionnaireService.checkQuestionnaire(input.getId(),currentUser.getUserId(input.getToken()),false);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @ApiOperation("搜索")
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05() {
        JSONResult jsonResult = new JSONResult();
        return jsonResult;
    }

    @ApiOperation("删除问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06(@Valid @RequestBody QuestionnaireA04InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        if (!currentUser.isUser(input.getToken())) {
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
        String message = questionnaireService.deleteQuestionnaire(input.getId(),currentUser.getUserId(input.getToken()));
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @ApiOperation("填写问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody QuestionnaireA07InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        if (!currentUser.isUser(input.getToken())) {
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
        int userId = currentUser.getUserId(input.getToken());
        List<Record> recordList = new ArrayList<>();
        for (RecordDTO rd: input.getRecord()) {
            for (Integer optionId:rd.getOptions()) {
                Record record = new Record();
                record.setOptionId(optionId);
                record.setQuestionId(rd.getQuestion_id());
                record.setQuestionnaireId(rd.getQuestionnaire_id());
                record.setUserId(userId);
                record.setIp("localhost");
                recordList.add(record);
            }

        }
        this.questionnaireService.fillIn(recordList);
        jsonResult.setMessage("填写成功");
        return jsonResult;
    }

    @ApiOperation("查看填写记录")
    @RequestMapping(method = RequestMethod.POST, value = "/A08")
    public JSONResult A08() {
        JSONResult jsonResult = new JSONResult();
        return jsonResult;
    }
    @ApiOperation("获取用户问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody RequestDTO input) {
        JSONResult<List<QuestionnaireA09DTO>> jsonResult = new JSONResult<>();
        List<Questionnaire> questionnaireList = this.questionnaireService.getUserQuestionnaire(currentUser.getUserId(input.getToken()));
        if (questionnaireList.size() == 1 && null == questionnaireList.get(0) || questionnaireList.size() == 0) {
            jsonResult.setData(new ArrayList<>());
            return jsonResult;
        }
        List<QuestionnaireA09DTO> questionnaireA09DTOList = BeanMapper.mapList(questionnaireList, QuestionnaireA09DTO.class);
        jsonResult.setData(questionnaireA09DTOList);
        return jsonResult;
    }
    @ApiOperation("打开问卷")
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@Valid @RequestBody QuestionnaireA04InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        if (!currentUser.isUser(input.getToken())) {
            jsonResult.setMessage("该功能需要用户权限！");
            return jsonResult;
        }
        String message =  questionnaireService.checkQuestionnaire(input.getId(),currentUser.getUserId(input.getToken()),true);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
