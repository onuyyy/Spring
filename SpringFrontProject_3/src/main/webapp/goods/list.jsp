<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>

<div class="container-fluid">
	<div class="row">
			 <div class="col-md-3" v-for="vo in goods_list">
				  <div class="thumbnail">
					   <a :href="'detail.do?no='+vo.no">	<!-- 변수를 가져오려면 앞에 클론 : 을 찍어야 한다 -->
					     <img :src="vo.poster" :title="vo.name" alt="Lights" style="width:100%">
					     <div class="caption">
					       <p style="font-size:9px">{{vo.price}}&nbsp;</p>
					     </div>
					   </a>
				</div>
			 </div>
	</div>
	<div style="height:20px"></div>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
			  <li v-if="startPage>1"><a href="#" v-on:click="prev()">&lt;</a></li>
			  <li v-for=" i in range(startPage,endPage)" :class="i==curpage?'active':''"><a href="#">{{i}}</a></li>
			  <li v-if="endPage<totalpage"><a href="#" @click="next()">&gt;</a></li>
			</ul>
		</div>
	</div>
	<h3>최근 본 상품</h3>
	<hr>
	<div class="row">
	
	</div>
</div>

<script>
    new Vue({
        el: '.container-fluid',
        data: {
            goods_list: [],
            curpage: 1,
            totalpage: 0,
            startPage: 0,
            endPage: 0,
            goods_cookie: []
        },
        // 콜백 함수 => 생명주기 함수 ex) 생성자 
        mounted: function () {
            this.send();
        },
        // 사용자 정의 함수 => 호출해야 사용 가능
        methods: {
            send: function () {
                let _this = this; // function 안에는 this가 없어서 명시적으로 _this안에 this를 저장해둠
                // axios.get(), axios.post()
                axios.get("http://localhost/web/goods/list_vue.do", {
                    // 전송할 데이터 
                    params: {
                        page: this.curpage // key:value  ==> Mapper에 매개변수와 key 이름이 같아야 한다 **
                    }
                }).then(function (response) { // 결과 값 받음
                    // function 안에 들어왔기 때문에 this 사라짐 
                    console.log(response.data); // 오탈자 수정: reponse -> response
                    _this.goods_list = response.data;
                    _this.curpage = response.data[0].curpage;
                    _this.totalpage = response.data[0].totalpage;
                    _this.startPage = response.data[0].startPage;
                    _this.endPage = response.data[0].endPage;
                });
            },
            range: function (start, end) { // range 이름 중복 수정: range -> rangeFunc
                let arr = [];
                let length = end - start;
                for (let i = 0; i <= length; i++) {
                    arr[i] = start;
                    start++;
                }
                return arr;
            },
            prev: function () {
                this.curpage = this.startPage - 1;
                this.send();
            },
            next: function () {
                this.curpage = this.endPage + 1;
                this.send();
            }
        }
    });
</script>



</body>
</html>