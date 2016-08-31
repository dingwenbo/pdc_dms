
package cn.newtouch.dms.web.jqgrid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.dms.json.JsonUtils;
import cn.newtouch.dms.vo.jqgrid.JqGrid;
import cn.newtouch.dms.vo.jqgrid.Model;

public abstract class AbstractJqGridController {
    
    private JqGrid jqGrid;
    
    private String basePath;
    
    @ResponseBody
    @RequestMapping("/jqGrid")
    public String jqGrid(HttpServletRequest request, HttpServletResponse response) {
    	basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        jqGrid = new JqGrid();
        init(request);
        jqGrid.setColNames(getColNames());
        jqGrid.setColModel(getColModel());
        
        return JsonUtils.writeObject(jqGrid);
    }
    
    public abstract List<String> getColNames();
    
    public abstract List<Model> getColModel();
    
    public abstract void init(HttpServletRequest request);
    
    public JqGrid getJqGrid() {
        return jqGrid;
    }
    
    public void setUrl(String url) {
        this.getJqGrid().setUrl(basePath + url);
    }

    public void setWidth(Integer width) {
        this.getJqGrid().setWidth(width);
    }

    public void setHeight(Integer height) {
        this.getJqGrid().setHeight(height);
    }

    public void setMtype(String mtype) {
        this.getJqGrid().setMtype(mtype);
    }

    public void setDatatype(String datatype) {
        this.getJqGrid().setDatatype(datatype);
    }

    public void setColNames(List<String> colNames) {
        this.getJqGrid().setColNames(colNames);
    }

    public void setColModel(List<Model> colModel) {
        this.getJqGrid().setColModel(colModel);
    }

    public void setRownumbers(Boolean rownumbers) {
        this.getJqGrid().setRownumbers(rownumbers);
    }

    public void setRowNum(Integer rowNum) {
        this.getJqGrid().setRowNum(rowNum);
    }

    public void setRowList(List<Integer> rowList) {
        this.getJqGrid().setRowList(rowList);
    }

    public void setPager(String pager) {
        this.getJqGrid().setPager(pager);
    }

    public void setViewrecords(Boolean viewrecords) {
        this.getJqGrid().setViewrecords(viewrecords);
    }

    public void setCaption(String caption) {
        this.getJqGrid().setCaption(caption);
    }

    public void setFooterrow(Boolean footerrow) {
        this.getJqGrid().setFooterrow(footerrow);
    }

    public void setEditurl(String editurl) {
        this.getJqGrid().setEditurl(basePath + editurl);
    }
}
