<template>
<div> 학생 조건검색결과 
	<div class="login-form">
    <form >
        <h2 class="text-center">검색</h2>   
		<a >학년별 최고, 최저점수 학생 </a>    
        <div class="form-group">
            <input type="text" v-model ="optionhword" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="find" type="submit" class="btn btn-primary btn-block">search</button>
        </div> 
		<div v-for="i of searchs" :key="i.text">
			<a @click.prevent="findword(i.searchword)" >{{i.text}}</a>
		</div>
		
<!-- 	<a @click.prevent="namesOfStudents">1. 학생의 이름</a>
		<a @click.prevent="streamToArray">2. 스트림을 배열로 전환</a>
		<a @click.prevent="streamToMap">3. 스트림을 맵으로 전환. 학생이름이  key</a>
		<a @click.prevent="theNumberOfStudents">4. 학생의 수</a>
		<a @click.prevent="totalScore">5. 학생들 총점</a>
		<a @click.prevent="topStudent">6. 1등 학생</a>
		<a @click.prevent="getStat">7. 전체 학생 성적 통계</a>
		<a @click.prevent="nameList">8. 전체 학생 이름</a>
		<a @click.prevent="partioningBy">1.단순분할 (성별로 분할)</a>
		<a @click.prevent="partioningCountPerGender">2.단순분할 (성별 학생수)</a>
		<a @click.prevent="partioningTopPerGender">3.단순분할 (성별 1등)</a>
		<a @click.prevent="partioningRejectPerGender">4.다중분할 (성별 불합격자,  50점이하)</a>
		<a @click.prevent="groupingByBan">1. 단순 그룹화(반별로 그룹화)</a>
		<a @click.prevent="groupingByGrade">2. 단순그룹화(성적별로 그룹화)</a>
		<a @click.prevent="groupingByCountByLevel">3. 단순그룹화 + 통계(성적별 학생수))</a>
		<a @click.prevent="groupingByHakAndBan">4. 다중 그룹화 (학년별, 반별)</a>
		<a @click.prevent="groupingTopByHakAndBan">5. 다중 그룹화 +통계 (학년별, 반별  1등)</a>
		<a @click.prevent="groupingByStat">6. 다중그룹화 + 통계(학년별, 반별  성적그룹)</a> -->
    
    </form>
	</div>
<div v-if="result">
<table class ="table">
	<tr>
		<th>no.</th>
		<th>uid</th>
		<th>pw</th>
		<th>name</th>
		<th>birthday</th>
		<th>gender</th>
		<th>hak</th>
		<th>ban</th>
		<th>score</th>
		<th>role</th>
	</tr>
	<tr v-for="(i,j) of list" :key="j.id">
		<td>{{i.id}}</td>
		<td>{{i.userid}}</td>
		<td>{{i.passwd}}</td>
		<td>{{i.name}}</td>
		<td>{{i.birthday}}</td>
		<td>{{i.male}}</td>
		<td>{{i.hak}}</td>
		<td>{{i.ban}}</td>
		<td>{{i.score}}</td>
		<td>{{i.role}}</td>
	</tr>

</table>
</div>
</div>
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return{
			context:'http://localhost:8080/',
			list:[],
			searchword:'',
			result:false,
			optionhword:'',
			searchs:[
				{searchword:'namesOfStudents',text:'1학생의 이름'},
				{searchword:'streamToArray',text:'2스트림을 배열로 전환'},
				{searchword:'streamToMap',text:'3. 스트림을 맵으로 전환. 학생이름이 '},
				{searchword:'theNumberOfStudents',text:'4학생의 수'},
				{searchword:'totalScore',text:'5학생들 총점'},
				{searchword:'topStudent',text:'6 1등 학생'},
				{searchword:'getStat',text:'7전체 학생 성적 통계'},
				{searchword:'nameList',text:' 8전체 학생 이름'},
				{searchword:'partioningBy',text:'1단순분할 (성별로 분할)'},
				{searchword:'partioningCountPerGender',text:'2단순분할 (성별 학생수)'},
				{searchword:'partioningTopPerGender',text:'3.단순분할 (성별 1등)'},
				{searchword:'partioningRejectPerGender',text:'4.다중분할 (성별 불합격자,  50점이하)'},
				{searchword:'groupingByBan',text:'1. 단순 그룹화(반별로 그룹화'},
				{searchword:'groupingByGrade',text:'2. 단순그룹화(성적별로 그룹화)'},
				{searchword:'groupingByCountByLevel',text:'3. 단순그룹화 + 통계(성적별 학생수))'},
				{searchword:'groupingByHakAndBan',text:'4. 다중 그룹화 (학년별, 반별)'},
				{searchword:'groupingTopByHakAndBan',text:'5. 다중 그룹화 +통계 (학년별, 반별  1등)'},
				{searchword:'groupingByStat',text:'6. 다중그룹화 + 통계(학년별, 반별  성적그룹)'},			
				
			],
			
		}
		
	},
methods:{
	findword(searchword){
		this.searchword=searchword
		this.result=true	
		alert(searchword)

	axios
	.get(`${this.context}/students/${this.searchword}`, {
		params: { option : this.optionhword}
	})
	.then(res=>{
		alert(`count:${res.data}`)
		this.list = res.data
		
	})
	.catch(()=>{
		alert('fail')
	})
	}
}

}
</script>
<style scoped>
.table{border: 1px solid black}
.table tr{border: 1px solid black}
.table th{border: 1px solid black}
.table td{border: 1px solid black}
.login-form {
	width: 340px;
	margin: 50px auto;
}
.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.login-form h2 {
	margin: 0 0 15px;
}
.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}
.btn {        
	font-size: 15px;
	font-weight: bold;
}
</style>