package com.example.controller;

import com.example.demo.response.UpdateTeamInfoResponseVO;
import com.example.request.CreateTeamInfoRequestVO;
import com.example.request.DeleteTeamInfoRequestVO;
import com.example.request.UpdateTeamInfoRequestVO;
import com.example.response.CreateTeamInfoResponseVO;
import com.example.response.DeleteTeamInfoResponseVO;
import com.example.url.Url;
import com.example.response.GetTeamInfoResponseVO;
import com.example.service.TeamInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "CRUD試寫")
@Slf4j
@RestController
public class CrudTestController {

    @Autowired
    private TeamInfoService teamInfoService;

    @ApiOperation(value = "Get TeamInfo", notes = "抓取小組全部資料")
    @ApiResponses(
            value = {@ApiResponse(code = 400, message = "傳入參數錯誤")}
    )
    @GetMapping(Url.GET_TEAM_INFO)
    public ResponseEntity<GetTeamInfoResponseVO> getTeamInfoList(){
        log.info("Get TeamInfo");
        return new ResponseEntity<>(teamInfoService.getTeamInfo(), HttpStatus.OK);
    }

    @ApiOperation(value = "Create TeamInfo", notes = "新增資料")
    @ApiResponses(
            value = {@ApiResponse(code = 400, message = "傳入參數錯誤")}
    )
    @PostMapping(Url.CREATE_TEAM_INFO)
    public ResponseEntity<CreateTeamInfoResponseVO> createTeamInfo(@Valid @RequestBody CreateTeamInfoRequestVO request){
        log.info("Create TeamInfo");
        return new ResponseEntity<>(teamInfoService.createTeamInfo(request), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete TeamInfo", notes = "刪除資料")
    @ApiResponses(
            value = {@ApiResponse(code = 400, message = "ARGUMENT_ERROR = 傳入的參數有誤")}
    )
    @PostMapping(Url.DELETE_TEAM_INFO)
    public ResponseEntity<DeleteTeamInfoResponseVO> deleteTeamInfo(@Valid @RequestBody DeleteTeamInfoRequestVO request){
        log.info("Delete TeamInfo");
        return new ResponseEntity<>(teamInfoService.deleteTeamInfo(request), HttpStatus.OK);
    }

    @ApiOperation(value = "Update TeamInfo", notes = "更新資料")
    @ApiResponses(
            value = {@ApiResponse(code = 400, message = "ARGUMENT_ERROR = 傳入的參數有誤")}
    )
    @PostMapping(Url.UPDATE_TEAM_INFO)
    public ResponseEntity<UpdateTeamInfoResponseVO> updateTeamInfo(@Valid @RequestBody UpdateTeamInfoRequestVO requestVO){
        log.info("update team info");
        return new ResponseEntity<>(teamInfoService.updateTeamInfo(requestVO), HttpStatus.OK);
    }
}