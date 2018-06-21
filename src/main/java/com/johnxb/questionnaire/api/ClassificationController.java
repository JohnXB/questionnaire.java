package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Classification.ClassificationA01DTO;
import com.johnxb.questionnaire.entity.Classification;
import com.johnxb.questionnaire.service.ClassificationService;
import com.johnxb.questionnaire.utils.BeanMapper;
import com.johnxb.questionnaire.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ClassificationController(ClassificationService classificationService){
        this.classificationService = classificationService;
    }

    @ApiOperation("获取所有分类")
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(){
        JSONResult<List<ClassificationA01DTO>> jsonResult = new JSONResult<>();
        List<ClassificationA01DTO> classificationA01DTOList = new ArrayList<>();
        List<Classification> classificationList =  this.classificationService.getAllClassification();
        classificationA01DTOList = BeanMapper.mapList(classificationList,ClassificationA01DTO.class);
        jsonResult.setData(classificationA01DTOList);
        return jsonResult;
    }

    @ApiOperation("根据分类Id获取分类信息")
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid ){
        JSONResult<ClassificationA02DTO> jsonResult = new JSONResult<ClassificationA02DTO>();
        ClassificationA02DTO classificationA02DTO = new ClassificationA02DTO();
        Classification classification =  this.classificationService.getAllClassification();
        ClassificationA02DTO = BeanMapper.mapList(classificationList,ClassificationA01DTO.class);
        jsonResult.setData(classificationA01DTOList);
        return jsonResult;
    }
}
