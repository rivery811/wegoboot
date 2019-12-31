 <template>
 <div class ="join">
    <form >
       <div class="form-group" >
            <label for="name">id</label>
            <input type="text" id="id" class="form-control" v-model="id" required>          
        </div>
        <div >
            <label for="email">uID</label>
            <input type="email" id="uid" class="form-control"  v-model="userid" required>         
        </div>
        <div class="form-group" >
            <label for="name">Name</label>
            <input type="text" id="name" class="form-control" v-model="name" required>          
        </div>

        <div >
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" v-model="passwd" required>          
        </div>
        <div>
            <label for="password">생일</label>
            <input type="text" id="birth" class="form-control" v-model="birthday" required>           
        </div>
        <div>
            <label>gender</label>           
                <input type="radio" v-model ="gender" value="M" required>Male
                <input type="radio" v-model ="gender" value="F" required>Female               
        </div>
        <div>
            <label>role</label>           
                <input type="radio" v-model ="role" value="student" required>student
                <input type="radio" v-model ="role" value="teacher" required>teacher
                <input type="radio" v-model ="role" value="manager" required>manager                 
        </div>
        <button @click.prevent="register" type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</template>

<script>


export default {
  data(){
    return{
      
        id:'',
        userid:'',
        passwd: '',
        name: '',
        birthday :'',
        role:[],
        gender:[]
        }
        
    

    
  }

}
</script>
<style scoped>
.join{
  
  padding-top:5px;
  padding-left:5px;
  padding-right:5px;
  padding-bottom:5px
}
</style>