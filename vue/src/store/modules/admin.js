import axios from 'axios'
import Constant from "@/store/modules/mutation_types"
const state={
	admin:{},
	sidebars : [
				{menu:"학생목록",link:"/Students"},
				{menu:"조건별 검색",link:"/studentsFindSome"},	
				{menu:"학생성적수정",link:"/update"},
				{menu:"학생검색",link:"/studentFindOne"}
			],
			userid :'',
			passwd :null,

}
const getters={
	getAdmin: state => state.admin
}
const actions={
		async login(){
			alert('연결 ')
			alert(this.userid + this.passwd)
			let url=`${this.$store.state.context}/login`
			let data={
				userid: this.userid,
				passwd: this.passwd
			}
			let headers= {
				'authorization': 'JWT fefege..',
				'Accept' : 'application/json',
				'Content-Type': 'application/json'
			}
			axios
			.post(url,data,headers)
			.then(respose=>{
				if(respose.data.result === "success"){
					this.$store.state.commit(Constant.PERSON, respose.data.person)
					this.$store.commit(Constant.IS_AUTH, true)
					alert(`로그인성공 ${respose.data.person.name}`)
					alert(`로그인성공1 ${this.$store.state.person.name}`)
					if(this.$store.state.person.role == 'student'){
						this.$store.commit(Constant.SIDEBAR, 'student-sidebars')
						this.$store.commit(Constant.HEADETMSG, '학생화면')
						this.$router.push({path:'/mypage'})
						
					}else if(this.$store.state.person.role == 'manager'){
						this.$store.commit(Constant.SIDEBAR, 'manager-sidebars')
						this.$store.state.sidebar='manager-sidebars'
						this.$store.commit(Constant.HEADETMSG, '매니저화면')
						this.$router.push({path:'/admin'})
					}else{
						this.$store.state.sidebar='teacher-sidebars'
						this.$store.commit(Constant.SIDEBAR, 'teacher-sidebars')
						this.$store.commit(Constant.HEADETMSG, '교사화면')
						this.$router.push({path:'/students'})

					}
					
					
				}else{
					alert(`T.T`)
					this.$router.push({path:'/login'})
				} 
				
				
			})
			.catch(()=>{
				alert('dpftldhtm tlfvo')
			}) 
		},
	async register(){
      alert(this.birthday)
      alert(this.name)
      alert('롤'+this.role)
      let url=`${this.$store.state.context}/join`
			let data={
        userid:this.userid,
        passwd: this.passwd,
        name: this.name,
        birthday :this.birthday,
        role:this.role,
        gender:this.gender}
			let headers= {
				'authorization': 'JWT fefege..',
				'Accept' : 'application/json',
				'Content-Type': 'application/json'
      }
      axios
			.post(url,data,headers)
			.then(respose=>{ 
          alert(respose.data.result)
          if(respose.data.result==="success"){
              this.$router.push('login')
          }else{
            this.$router.push('join')
          }

			})
			.catch(()=>{
				alert('dpftldhtm tlfvo')
			}) 

    }

}
const mutations={
	LOGIN (state, person) {
        state.person = person
    },
    LOGOUT (state) {
        state.person = null
    }
}
export default{
	namespaced:true,
	state,
	getters,
	actions,
	mutations,
}