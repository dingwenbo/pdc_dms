package cn.newtouch.dms.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.entity.Role;
import cn.newtouch.dms.vo.member.MemberVO;

/**
 * The Interface MemberMapper.
 */
@Mapper(uses = DateMapper.class)
public interface MemberMapper {

    /** The instance. */
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    /**
     * Member and role to member vo.
     *
     * @param member the member
     * @param role the role
     * @return the member vo
     */
    @Mapping(source = "member.registerDate", target = "registerDate")
    @Mapping(source = "role.code", target = "roleCode")
    @Mapping(source = "member.id", target = "id")
    @Mapping(source = "member.gender", target = "gender", defaultValue = "未知")
    @Mapping(target = "phone", expression = "java( cn.newtouch.dms.util.StringUtil.formatStr( member.getPhone() ) )")
    MemberVO memberAndRoleToMemberVo(Member member, Role role);

    /**
     * Member vo to member.
     *
     * @param memberVo the member vo
     * @return the member
     */
    @InheritInverseConfiguration
    Member memberVOToMember(MemberVO memberVo);
}
