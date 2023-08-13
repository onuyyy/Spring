<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">

.joinContainer {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 520px;
    height:0px auto;
}	
</style>

<script type="text/javascript">

$(function(){
	$('#postBtn').click(function(){
		new daum.Postcode({
			oncomplete:function(data) {
				$('#post').val(data.zonecode)
				$('#addr1').val(data.address)
			}
		}).open()
	})
})

</script>
</head>
<body>

	<div class="joinContainer">
		<table class="table">
			<div class="text-center">
				<h3>회원가입</h3>
				회원이 되어 다양한 혜택을 경험해 보세요!
			</div>
			<tr>
			    <th>아이디</th>
			</tr>
			<tr>
			    <td>
			        <input type="text" placeholder="아이디 입력(6~20자)" size=40 v-model="id" ref="id" >
			        <span v-if="id !== ''">
			            <button class="btn btn-sm btn-default" id="idCheck" @click="idCheck">중복 확인</button>
			        </span>
			    </td>
			</tr>
			<tr>
				<th>비밀번호</th>
			</tr>
			<tr>	
			    <td><input type="password" placeholder="비밀번호 입력(8~20자)" size=50 v-model="pwd" ref="pwd"></td>
			</tr>
			<tr>
			    <th>비밀번호 확인<span v-show="!checkPasswordsMatch()" style="color:red">&nbsp;(비밀번호가 일치하지 않습니다.)</span></th>
			</tr>
			<tr>    
			    <td>
			        <input type="password" placeholder="비밀번호 재입력" size="50" v-model="confirmPwd">
			    </td>
			</tr>
			<tr>
				<th>이름</th>
			</tr>
			<tr>	
				<td><input type=text placeholder="이름을 입력해주세요" size=50 ref="name" v-model="name"></td>
			</tr>
			<tr>
				<th>이메일</th>
			</tr>
			<tr>	
				<td><input type=text name=email placeholder="이메일을 입력해주세요" size=50 ref="email" v-model="email"></td>
			</tr>
			<tr>
				<th>닉네임</th>
			</tr>
			<tr>	
				<td><input type=text name=nickname placeholder="닉네임을 입력해주세요" size=50 ref="nickname" v-model="nickname"></td>
			</tr>
			<tr>
				<th>성별</th>
			</tr>
			<tr>	
				<td>
				남자<input type=radio name=sex value="남자" checked v-model="sex">
				여자<input type=radio name=sex value="여자" v-model="sex">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
			</tr>
			<tr>	
				<td><input type=text name=birth size=50 ref="birth" v-model="birth"></td>
			</tr>
			<tr>
				<th>전화번호</th>
			</tr>
			<tr>	
				<td><input type=text name=phone size=50 ref="phone" v-model="phone"></td>
			</tr>
			<tr>
				<th>우편번호</th>
			</tr>
			<tr>	
				<td>
				<input type=text name=post id=post class="input-sm" ref="post" v-model="post">
				<input type=button id="postBtn" value="우편번호 검색" class="btn btn-sm btn-default" size=40>
				</td>
			</tr>
			<tr>
				<th>주소</th>
			</tr>
			<tr>	
				<td>
				<input type=text name=addr1 id=addr1 size=50 ref="addr1" v-model="addr1">
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
			</tr>
			<tr>	
				<td>
				<input type=text name=addr2 id=addr2 size=50 ref="addr2" v-model="addr2">
				</td>
			</tr>
	            <tr style="text-align: center;">
	                <td colspan="2">
	                    <input type=submit name="joinBtn" value="회원가입" @click="join">
	                    <input type=button name="joinBtn" value="취소" onclick="javascript:history.back()">
	                </td>
	            </tr>
		</table>
	</div>

<script>

new Vue({
	el: '.joinContainer',
	data: {
		confirmPwd: '',
		id: '',
		pwd: '',
		email: '',
		name: '',
		nickname: '',
		sex: '남자',
		birth: '',
		phone: '',
		post: '',
		addr1: '',
		addr2: ''
	},
	methods: {
		checkPasswordsMatch() {
			return this.pwd === this.confirmPwd;
		},
		idCheck() {
			let id = this.id
			axios.post('../member/idCheck.do', null, {
				params: {
					id: this.id
				}
			}).then(response => {
				let res = response.data;
				if (res === "OK") {
					alert("사용 가능한 ID입니다!")
				} else {
					alert("이미 가입된 ID입니다!")
				}
			})
		},
		join() {
			if (this.id === "") {
				alert("ID를 입력해주세요.");
				this.$refs.id.focus();
				return;
			}
			if (this.pwd === "") {
				alert("Password를 입력해주세요.");
				this.$refs.pwd.focus();
				return;
			}
			if (this.email === "") {
				alert("이메일을 입력해주세요.");
				this.$refs.email.focus();
				return;
			}
			if (this.name === "") {
				alert("이름을 입력해주세요.");
				this.$refs.name.focus();
				return;
			}
			if (this.nickname === "") {
				alert("닉네임을 입력해주세요.");
				this.$refs.nickname.focus();
				return;
			}
			if (this.sex === "") {
				alert("성별을 체크해주세요.");
				return;
			}	
			if (this.birth === "") {
			    alert("생년월일을 입력해주세요.");
			    this.$refs.birth.focus();
			    return;
			}
			if (this.phone === "") {
				alert("연락처를 입력해주세요.");
				this.$refs.phone.focus();
				return;
			}
			if (this.addr1 === "") {
				alert("주소를 입력해주세요.");
				this.$refs.addr1.focus();
				return;
			}
			if (this.addr2 === "") {
				alert("상세주소를 입력해주세요.");
				this.$refs.addr2.focus();
				return;
			}
			axios.post('../member/join_ok.do',null, {
				params:{
					id: this.id,
					pwd: this.pwd,
					email: this.email,
					name: this.name,
					nickname: this.nickname,
					sex: this.sex,
					birth: this.birth,
					phone: this.phone,
					post: this.post,
					addr1: this.addr1,
					addr2: this.addr2
				}
			}).then(response => {
				let res = response.data;
				/* console.log(res); */
				if (res === "YES") {
					alert("회원가입이 완료되었습니다!");
					location.href = "../member/main.do";
				} else {
					alert("회원가입이 실패했습니다!");
				}
			})
		}
	}
});

</script>
</body>
</html>