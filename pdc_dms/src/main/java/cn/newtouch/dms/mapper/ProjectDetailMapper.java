package cn.newtouch.dms.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.vo.project.ProjectDetailVO;

@Mapper
public interface ProjectDetailMapper {
	
	ProjectDetailMapper INSTANCE = Mappers.getMapper(ProjectDetailMapper.class);
	
	@Mapping(source = "project.parent.code", target = "parentCode")
	@Mapping(source = "project.manager.name", target= "managerName")
	@Mapping(source = "project.manager.id", target = "managerId")
	ProjectDetailVO projectToProjectDetailVO(Project project);
	
	@InheritInverseConfiguration
	Project projectDetailVOToProject(ProjectDetailVO projectDetailVO);
}
