<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 900px;
}
</style>
</head>
<body>

<div class="container">
	<h3 class="text-center">회원가입</h3>
	<div class="row">
		<table class="table">
			<tr>
				<td width=20% class="text-center">ID</td>
				<td width=80%>
				<input type=text ref="id" size=15 class="input-sm" v-model="id">
			</tr>
			<tr>
				<td width=20% class="text-center">Password</td>
				<td width=80%>
				<input type=password ref="pwd" size=15 class="input-sm" v-model="pwd">
			</tr>
			<tr>
				<td width=20% class="text-center">Name</td>
				<td width=80%>
				<input type=text ref="name" size=15 class="input-sm" v-model="name">
			</tr>
			<tr>
				<td width=20% class="text-center">Sex</td>
				<td width=80%>
				<input type="radio" ref="sex" value="남자" checked name="sex" v-model="sex">남자
				<input type="radio" ref="sex" value="여자" name="sex"  v-model="sex">여자	
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type=button value="회원가입" class="btn btn-sm btn-danger" @click="join()">
					<input type=button value="취소" class="btn btn-sm btn-danger" onclick="javascript:history.back()">			
				</td>
			</tr>
		</table>
	</div>
</div>	

<script>

	new Vue({
		el:'.container',
		data:{
			// 이거 쓸 때 this.
			id:'',
			pwd:'',
			name:'',
			sex:'남자'
		},
		methods:{
			join(){
				// 함수호출 @click= ,v-on:click
				let id=this.$refs.id.value;
				if(id.trim()==="") {
					this.$refs.id.focus();
					alert("id 입력")
					return;
				}
				let pwd=this.$refs.pwd.value;
				if(pwd.trim()==="") {
					this.$refs.pwd.focus();
					alert("pwd 입력")
					return;
				}
				let name=this.$refs.name.value;
				if(name.trim()==="") {
					this.$refs.name.focus();
					alert("이름 입력")
					return;
				}
				// post로 넘겼으니 postmapping으로 받아라
				axios.post('http://localhost/web/member/join_ok.do',null,{
					params:{
						id:this.id,
						pwd:this.pwd,
						name:this.name,
						sex:this.sex
					}
				}).then(response=>{
					let res=response.data;
					console.log(res)
					if(res==='NO') {
						alert("회원 가입 실패")
						// 실패 후 값 공백으로 두기
						this.id='';
						this.pwd='';
						this.name='';
						this.sex='남자';
						this.$refs.id.focus()
					} else {
						location.href="../member/login.do";
					}
				})
			}
		}
	})
	
</script>

</body>
</html>