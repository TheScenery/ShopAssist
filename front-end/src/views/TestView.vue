<script setup>
import { ref } from 'vue';
import ModalDialog from '@/components/dialog/ModalDialog.vue';

const text = ref(true);

</script>

<template>
  <ModalDialog v-model='text' />
  {{ text }}
</template>

<style scoped lang='scss'>

</style>