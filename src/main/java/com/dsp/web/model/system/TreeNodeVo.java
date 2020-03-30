package com.dsp.web.model.system;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeVo {
    private String id;
    private String name;
    private String parentId;
    private List<TreeNodeVo> children;
    private String level;
    private String orgType;
    private String validateState;
    public static   List<TreeNodeVo>  treeBuild(List<TreeNodeVo> list) {

        List<TreeNodeVo> nodeList = new ArrayList();
        for (TreeNodeVo node1 : list) {//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List

            boolean mark = false;
            for (TreeNodeVo node2 : list) {
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getId())) {
                    mark = true;
                    if (node2.getChildren() == null) {
                        node2.setChildren(new ArrayList<TreeNodeVo>());
                    }
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeNodeVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeVo> children) {
        this.children = children;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getValidateState() {
        return validateState;
    }

    public void setValidateState(String validateState) {
        this.validateState = validateState;
    }
}
