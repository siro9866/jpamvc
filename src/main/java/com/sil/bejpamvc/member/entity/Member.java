package com.sil.bejpamvc.member.entity;

import com.sil.bejpamvc.common.entiti.Base;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * 회원
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE MEMBER SET DELETED_YN = 'Y' WHERE MEMBER_SEQ = ?")
@SQLRestriction("DELETED_YN = 'N'")
@DynamicInsert
@DynamicUpdate
@Table(name = "MEMBER")
public class Member extends Base {

	@Comment("순번")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_SEQ")
	private Long memberSeq;
	
	@Comment("아이디")
	@Column(name = "MEMBER_ID", unique = true, nullable = false, length = 20)
	private String memberId;

	@Comment("비밀번호")
	@Column(name = "PASSWORD", nullable = false, length =100)
	private String password;

	@Comment("이름")
	@Column(name = "MEMBER_NAME", nullable = false, length = 50)
	private String memberName;

	@Comment("이메일")
	@Column(name = "MEMBER_EMAIL", nullable = false, length = 100)
	private String memberEmail;

	@Comment("권한")
	@ColumnDefault("'ROLE_MEMBER'") // default
	@Column(name = "MEMBER_ROLE", length =50)
	private String memberRole;

	@Comment("가입일시")
	@CreatedDate
	@Column(name = "JOIN_DTTM", nullable = false, updatable = false)
	private LocalDateTime joinDttm;
	
	@Comment("로그인일시")
	@Column(name = "SIGN_DTTM", nullable = true)
	private LocalDateTime signDttm;
	
	@Comment("삭제여부")
	@ColumnDefault("'N'")
	@Column(name = "DELETED_YN", nullable = false, length = 1)
	private String deletedYn;

}
