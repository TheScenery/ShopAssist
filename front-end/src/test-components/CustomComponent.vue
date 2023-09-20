<script setup>
defineProps(['modelValue']);
defineEmits(['update:modelValue']);
</script>

<template>
  <ElButton
    @click="$emit('update:modelValue', !modelValue)"
  >
    {{ modelValue }}
  </ElButton>
</template>