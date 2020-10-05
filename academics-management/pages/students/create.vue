<template>
  <div>
    <div class="jumbotron" style="text-align: center">
      <h1>Register New Student</h1>
    </div>
  <b-form @submit="create" @reset="onReset">
    <b-form-group id="inputUsername" label="Username:" label-for="input-username">
      <b-form-input
        id="input-username"
        v-model="username"
        required
        placeholder="Enter Username"
      ></b-form-input>
    </b-form-group>



    <b-form-group id="inputName" label="Name:" label-for="input-name">
      <b-form-input
        id="input-name"
        v-model="name"
        required
        placeholder="Enter name"
      ></b-form-input>
    </b-form-group>
    <b-form-group id="inputEmail" label="Email:" label-for="input-email">
      <b-form-input
        id="input-email"
        v-model="name"
        required
        placeholder="Enter name"
      ></b-form-input>
    </b-form-group>
    <b-form-group id="textPassword" label="Password:" label-for="text-password">
      <b-input type="password" id="text-password" aria-describedby="password-help-block"></b-input>
      <b-form-text id="password-help-block">
        Your password must be 8-20 characters long, contain letters and numbers, and must not
        contain spaces, special characters, or emoji.
      </b-form-text>
    </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
    <b-button type="reset" variant="danger">Reset</b-button>
  </b-form>
    <div>
      course code:<select v-model="courseCode"><template v-for="course in courses"><option :key="course.code" :value="course.code">{{ course.name }}</option>
    </template>
    </select>

    </div>

  </div>
</template>
<script>
export default {
  data() {
  return {
  username: null,
    password: null,
    name: null,
    email: null,
    courseCode: null,
    courses: []
}
    },
  created() {
    this.$axios.$get('/api/courses').
    then(courses => {this.courses = courses})},
  methods: {
    create() {
      this.$axios.$post('/api/students',
        {username: this.username,password: this.password,name: this.name,email: this.email,courseCode: this.courseCode})
        .then(() => {this.$router.push('/')
        })
    }
  }
}

</script>
