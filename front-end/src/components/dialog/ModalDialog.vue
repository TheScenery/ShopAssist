<script setup>

import { computed } from 'vue';

const props = defineProps({
  modelValue: Boolean,
  title: String
});
const emit = defineEmits(['update:modelValue', 'onOk']);

const visible = computed({
  get () {
    return props.modelValue;
  },
  set (value) {
    emit('update:modelValue', value);
  }
});

const onClose = () => {
  visible.value = false;
};

const onConfirm = () => {
  emit('onOk');
  onClose();
};

</script>

<template>
  <el-dialog v-model='visible' :title='title' :close-on-click-modal='false' :close-on-press-escape='false'>
    <slot></slot>
    <template #footer>
      <span class='dialog-footer'>
        <el-button @click='onClose'>{{ $t('cancel') }}</el-button>
        <el-button type='primary' @click='onConfirm'>
          {{ $t('confirm') }}
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped lang='scss'>

</style>