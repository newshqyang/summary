[1.Activity 切换时的生命周期](#Activity-切换时的生命周期)

1.Activity 切换时的生命周期：
(小米)
> [1] MainActivity 跳转到 SecondActivity 的生命周期：<br>
①Main.onPause() → ②Second.onCreate() → ③Second.onStart() → ④Second.onResume() → ⑤Main.onStop()<br><br>
> [2] SecondActivity 返回 MainActivity 的生命周期：<br>
①Second.onPause() → ②Main.onRestart() → ③Main.onStart() → ④Main.onResume() → ⑤Second.onStop() → ⑥Second.onDestroy()