package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Classification.*;
import com.johnxb.questionnaire.dto.RequestDTO;
import com.johnxb.questionnaire.entity.Classification;
import com.johnxb.questionnaire.service.ClassificationService;
import com.johnxb.questionnaire.service.ICurrentUser;
import com.johnxb.questionnaire.utils.BeanMapper;
import com.johnxb.questionnaire.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "问卷分类Api")
@RequestMapping("/Classification")
public class ClassificationController {
    private final ClassificationService classificationService;

    private final ICurrentUser currentUser;
    @Autowired
    public ClassificationController(ClassificationService classificationService,ICurrentUser currentUser) {
        this.classificationService = classificationService;
        this.currentUser = currentUser;
    }
    @ApiOperation("获取所有可见分类")
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01() {
        JSONResult<List<ClassificationA01DTO>> jsonResult = new JSONResult<>();
        List<ClassificationA01DTO> classificationA01DTOList = new ArrayList<>();
        List<Classification> classificationList = this.classificationService.getAllClassification();
        classificationA01DTOList = BeanMapper.mapList(classificationList, ClassificationA01DTO.class);
        jsonResult.setData(classificationA01DTOList);
        return jsonResult;
    }

    @ApiOperation("根据分类Id获取分类信息")
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid ClassificationA02InputDTO input) {
        JSONResult<ClassificationA02DTO> jsonResult = new JSONResult<>();

        ClassificationA02DTO classificationA02DTO = new ClassificationA02DTO();
        Classification classification = this.classificationService.getClassificationById(input.getClassificationId());
        classificationA02DTO = BeanMapper.map(classification, ClassificationA02DTO.class);
        int count = this.classificationService.selectCountByClassificationId(input.getClassificationId());
        classificationA02DTO.setCount(count);
        jsonResult.setData(classificationA02DTO);
        return jsonResult;
    }
    @ApiOperation("获取所有分类(管理员)")
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid RequestDTO input) {
        JSONResult<List<ClassificationA03DTO>> jsonResult = new JSONResult<>();
        if(!currentUser.isAdmin(input.getToken())){
            jsonResult.setMessage("权限不够");
            return jsonResult;
        }
        List<ClassificationA03DTO> classificationA03DTOList = new ArrayList<>();
        List<Classification> classificationList = this.classificationService.getAllClassificationByAdmin();
        classificationA03DTOList = BeanMapper.mapList(classificationList, ClassificationA03DTO.class);
        jsonResult.setData(classificationA03DTOList);
        return jsonResult;
    }

    @ApiOperation("修改分类信息(管理员)")
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid ClassificationA04InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();

        if(currentUser.isAdmin(input.getToken())){
            jsonResult.setMessage("权限不够");
            return jsonResult;
        }
        Classification classification = BeanMapper.map(input,Classification.class);

        this.classificationService.changeStatus(classification);

        jsonResult.setMessage("成功修改分类信息");
        return jsonResult;
    }
    @ApiOperation("增加分类(管理员)")
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid ClassificationA05InputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        if(currentUser.isAdmin(input.getToken())){
            jsonResult.setMessage("权限不够");
            return jsonResult;
        }
        Classification classification = BeanMapper.map(input,Classification.class);
        classification.setCreator(currentUser.getUserId(input.getToken()));
        this.classificationService.addClassification(classification);

        jsonResult.setMessage("成功增加分类信息");
        return jsonResult;
    }
}
