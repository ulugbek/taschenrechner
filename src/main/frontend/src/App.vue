<template>
  <CalcHeader />
  <CalcMain />
</template>

<script>
import CalcHeader from './components/CalcHeader.vue'
import CalcMain from './components/CalcMain.vue'
document.title = 'Taschenrechner'

export default {
  name: 'App',
  components: {
    CalcHeader,
    CalcMain
  }
}
</script>

<style>
  @import './assets/styles/global.css';
</style>
