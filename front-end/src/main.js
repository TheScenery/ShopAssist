import './assets/main.css';
import 'element-plus/dist/index.css';

import { createApp } from 'vue';
import { createI18n } from 'vue-i18n';
import App from './App.vue';
import router from './router';
import ElementPlus from 'element-plus';
import zhCn from '@/i18n/zh-CN.json';

const app = createApp(App);
const i18n = createI18n({
  locale: 'zh',
  messages: {
    zh: zhCn
  },
  legacy: false
});

app.use(router);
app.use(i18n);
app.use(ElementPlus);

app.mount('#app');
