package vip.justlive.frost.center.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vip.justlive.common.base.domain.Response;
import vip.justlive.frost.api.model.JobExecuteRecord;
import vip.justlive.frost.api.model.JobExecutor;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.api.model.JobScript;
import vip.justlive.frost.api.model.JobStatictis;
import vip.justlive.frost.api.model.Page;
import vip.justlive.frost.core.service.JobService;

/**
 * 调度中心Controller
 * 
 * @author wubo
 *
 */
@RestController
public class CenterController {

  @Autowired
  JobService jobService;

  /**
   * 登录页面
   * 
   * @return
   */
  @RequestMapping("/login.html")
  public ModelAndView login() {

    return new ModelAndView("login/login.html");
  }

  /**
   * 首页
   * 
   * @return
   */
  @RequestMapping({"/", "index.html"})
  public ModelAndView index() {

    return new ModelAndView("index.html");
  }


  /**
   * 获取当前执行器列表
   * 
   * @return
   */
  @RequestMapping("/queryExecutors")
  public Response<List<JobExecutor>> queryExecutors() {
    List<JobExecutor> list = jobService.queryExecutors();
    return Response.success(list);
  }

  /**
   * 增加job
   * 
   * @param jobInfo
   * @return
   */
  @RequestMapping("/addJob")
  public Response<String> addJob(@RequestBody JobInfo jobInfo) {
    String jobId = jobService.addJob(jobInfo);
    return Response.success(jobId);
  }

  /**
   * 修改job
   * 
   * @param jobInfo
   * @return
   */
  @RequestMapping("/updateJob")
  public Response<String> updateJob(@RequestBody JobInfo jobInfo) {
    jobService.updateJob(jobInfo);
    return Response.success("修改成功");
  }

  /**
   * 暂停job
   * 
   * @param id
   * @return
   */
  @RequestMapping("/pauseJob")
  public Response<String> pauseJob(String id) {
    jobService.pauseJob(id);
    return Response.success("暂停成功");
  }

  /**
   * 恢复job
   * 
   * @param id
   * @return
   */
  @RequestMapping("/resumeJob")
  public Response<String> resumeJob(String id) {
    jobService.resumeJob(id);
    return Response.success("恢复成功");
  }

  /**
   * 删除job
   * 
   * @param id
   * @return
   */
  @RequestMapping("/removeJob")
  public Response<String> removeJob(String id) {
    jobService.removeJob(id);
    return Response.success("删除成功");
  }

  /**
   * 触发job
   * 
   * @param id
   * @return
   */
  @RequestMapping("/triggerJob")
  public Response<String> triggerJob(String id) {
    jobService.triggerJob(id);
    return Response.success("触发成功");
  }


  /**
   * 获取job列表
   * 
   * @return
   */
  @RequestMapping("/queryJobInfos")
  public Response<Page<JobInfo>> queryJobInfos(@RequestParam(defaultValue = "1") int pageIndex,
      @RequestParam(defaultValue = "10") int pageSize) {
    Page<JobInfo> jobInfos = jobService.queryJobInfos(pageIndex, pageSize);
    return Response.success(jobInfos);
  }

  /**
   * 获取所有任务
   * 
   * @param pageIndex
   * @param pageSize
   * @return
   */
  @RequestMapping("/queryAllJobs")
  public Response<List<JobInfo>> queryAllJobs() {
    List<JobInfo> jobInfos = jobService.queryAllJobs();
    return Response.success(jobInfos);
  }

  /**
   * 获取job
   * 
   * @param id
   * @return
   */
  @RequestMapping("/findJobInfoById")
  public Response<JobInfo> findJobInfoById(String id) {
    return Response.success(jobService.findJobInfoById(id));
  }

  /**
   * 获取job执行记录列表
   * 
   * @param groupKey
   * @param jobKey
   * @param jobId
   * @param from
   * @param to
   * @return
   */
  @RequestMapping("/queryJobExecuteRecords")
  public Response<Page<JobExecuteRecord>> queryJobExecuteRecords(String groupKey, String jobKey,
      String jobId, @RequestParam(defaultValue = "1") int pageIndex,
      @RequestParam(defaultValue = "10") int pageSize) {
    Page<JobExecuteRecord> records =
        jobService.queryJobRecords(groupKey, jobKey, jobId, pageIndex, pageSize);
    return Response.success(records);
  }

  /**
   * 增加任务脚本
   * 
   * @param script
   * @return
   */
  @RequestMapping("/addJobScript")
  public Response<String> addJobScript(@RequestBody JobScript script) {
    jobService.addJobScript(script);
    return Response.success("操作成功");
  }

  /**
   * 查询任务脚本
   * 
   * @param jobId
   * @return
   */
  @RequestMapping("/queryJobScripts")
  public Response<List<JobScript>> queryJobScripts(String jobId) {
    return Response.success(jobService.queryJobScripts(jobId));
  }

  /**
   * 任务统计
   * 
   * @param begin
   * @param end
   * @return
   */
  @RequestMapping("/queryJobStatictis")
  public Response<JobStatictis> queryJobStatictis(String begin, String end) {
    return Response.success(jobService.queryJobStatictis(begin, end));
  }
}
