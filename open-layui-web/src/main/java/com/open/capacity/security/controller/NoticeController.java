package com.open.capacity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.NoticeDao;
import com.open.capacity.security.dto.NoticeReadVO;
import com.open.capacity.security.dto.NoticeVO;
import com.open.capacity.security.model.Notice;
import com.open.capacity.security.model.Notice.Status;
import com.open.capacity.security.model.SysUser;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.utils.UserUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "公告")
@RestController
@RequestMapping("/notices")
public class NoticeController {

	@Autowired
	private NoticeDao noticeDao;

	@LogAnnotation
	@PostMapping
	@ApiOperation(value = "保存公告")
	@PreAuthorize("hasAuthority('notice:add')")
	public Notice saveNotice(@RequestBody Notice notice) {
		noticeDao.save(notice);

		return notice;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取公告")
	@PreAuthorize("hasAuthority('notice:query')")
	public Notice get(@PathVariable Long id) {
		return noticeDao.getById(id);
	}

	@GetMapping(params = "id")
	public NoticeVO readNotice(Long id) {
		NoticeVO vo = new NoticeVO();

		Notice notice = noticeDao.getById(id);
		if (notice == null || notice.getStatus() == Status.DRAFT) {
			return vo;
		}
		vo.setNotice(notice);

		noticeDao.saveReadRecord(notice.getId(), UserUtil.getLoginUser().getId());

		List<SysUser> users = noticeDao.listReadUsers(id);
		vo.setUsers(users);

		return vo;
	}

	@LogAnnotation
	@PutMapping
	@ApiOperation(value = "修改公告")
	@PreAuthorize("hasAuthority('notice:add')")
	public Notice updateNotice(@RequestBody Notice notice) {
		Notice no = noticeDao.getById(notice.getId());
		if (no.getStatus() == Status.PUBLISH) {
			throw new IllegalArgumentException("发布状态的不能修改");
		}
		noticeDao.update(notice);

		return notice;
	}

	@GetMapping
	@ApiOperation(value = "公告管理列表")
	@PreAuthorize("hasAuthority('notice:query')")
	public PageTableResponse listNotice(PageTableRequest request) {
		return new PageTableHandler(new CountHandler() {

			@Override
			public int count(PageTableRequest request) {
				return noticeDao.count(request.getParams());
			}
		}, new ListHandler() {

			@Override
			public List<Notice> list(PageTableRequest request) {
				return noticeDao.list(request.getParams(), request.getOffset(), request.getLimit());
			}
		}).handle(request);
	}

	@LogAnnotation
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除公告")
	@PreAuthorize("hasAuthority('notice:del')")
	public void delete(@PathVariable Long id) {
		noticeDao.delete(id);
	}

	@ApiOperation(value = "未读公告数")
	@GetMapping("/count-unread")
	public Integer countUnread() {
		SysUser user = UserUtil.getLoginUser();
		return noticeDao.countUnread(user.getId());
	}

	@GetMapping("/published")
	@ApiOperation(value = "公告列表")
	public PageTableResponse listNoticeReadVO(PageTableRequest request) {
		request.getParams().put("userId", UserUtil.getLoginUser().getId());

		return new PageTableHandler(new CountHandler() {

			@Override
			public int count(PageTableRequest request) {
				return noticeDao.countNotice(request.getParams());
			}
		}, new ListHandler() {

			@Override
			public List<NoticeReadVO> list(PageTableRequest request) {
				return noticeDao.listNotice(request.getParams(), request.getOffset(), request.getLimit());
			}
		}).handle(request);
	}
}
