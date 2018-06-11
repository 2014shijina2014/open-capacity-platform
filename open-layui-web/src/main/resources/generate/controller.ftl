package {controllerPkgName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import {daoPackageName}.{daoName};
import {beanPackageName}.{beanName};

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/{beanParamName}s")
public class {controllerName} {

    @Autowired
    private {daoName} {daoParamName};

    @PostMapping
    @ApiOperation(value = "保存")
    public {beanName} save(@RequestBody {beanName} {beanParamName}) {
        {daoParamName}.save({beanParamName});

        return {beanParamName};
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public {beanName} get(@PathVariable Long id) {
        return {daoParamName}.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public {beanName} update(@RequestBody {beanName} {beanParamName}) {
        {daoParamName}.update({beanParamName});

        return {beanParamName};
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return {daoParamName}.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<{beanName}> list(PageTableRequest request) {
                return {daoParamName}.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        {daoParamName}.delete(id);
    }
}
