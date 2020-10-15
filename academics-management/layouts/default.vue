<template>
  <div>
    <b-navbar type="dark" variant="dark" style="list-style: none">
      <b-nav-item><i class="fa fa-fw fa-home"></i> Home</b-nav-item>
      <b-nav-item-dropdown text="Student" center>
        <b-dropdown-item @click="clickNavbar('/students')">See Student List</b-dropdown-item>
        <b-dropdown-item @click="clickNavbar('/students/create')"> Create student</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-nav-item-dropdown text="Courses" center>
        <b-dropdown-item @click="clickNavbar('/courses')">See Courses List</b-dropdown-item>
        <b-dropdown-item> Under Construction!</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-nav-item-dropdown text="Subjects" center>
        <b-dropdown-item @click="clickNavbar('/subjects')">See Subject List</b-dropdown-item>
        <b-dropdown-item> Under Construction!</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-navbar>
    <Nuxt />
  </div>
</template>
<script>
export default {
  methods:{
    clickNavbar(route){
      this.$router.push(route)
    }
  }
}
</script>
<style>
</style>
