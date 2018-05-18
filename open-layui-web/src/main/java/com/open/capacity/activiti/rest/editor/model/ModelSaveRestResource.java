package com.open.capacity.activiti.rest.editor.model;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-17 17:55]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Tijs Rademakers
 */
@RestController
@RequestMapping("service")
@Slf4j
public class ModelSaveRestResource implements ModelDataJsonConstants {

    @Autowired
    private RepositoryService repositoryService;


    @PostMapping(value="/model/{modelId}/save")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveModel(@PathVariable String modelId
            , String name, String description
            , String json_xml, String svg_xml,HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> map= request.getParameterMap();
            JSONObject jsonObject=new JSONObject();
            //全跑到key了，可取方案
            for(Map.Entry<String,String[]> entry:map.entrySet()){
                if (entry.getKey().equals("token")){
                    continue;
                }
                String data=entry.getKey()+"="+(entry.getValue()[0]);
                jsonObject= JSON.parseObject(data);
            }
            name= (String) jsonObject.get("name");
            description= (String) jsonObject.get("description");
            json_xml= (String) jsonObject.get("json_xml");
            svg_xml= (String) jsonObject.get("svg_xml");

            Model model = repositoryService.getModel(modelId);
            JSONObject object=new JSONObject();
            object.put(MODEL_NAME, name);
            object.put(MODEL_DESCRIPTION, description);
            model.setMetaInfo(object.toString());
            model.setName(name);
            repositoryService.saveModel(model);

            repositoryService.addModelEditorSource(model.getId(), json_xml.getBytes("utf-8"));

            InputStream svgStream = new ByteArrayInputStream(svg_xml.getBytes("utf-8"));
            TranscoderInput input = new TranscoderInput(svgStream);

            PNGTranscoder transcoder = new PNGTranscoder();
            // Setup output
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outStream);

            // Do the transformation
            transcoder.transcode(input, output);
            final byte[] result = outStream.toByteArray();
            repositoryService.addModelEditorSourceExtra(model.getId(), result);
            outStream.close();

        } catch (Exception e) {
            log.error("Error saving model", e);
            throw new ActivitiException("Error saving model", e);
        }
    }
}
