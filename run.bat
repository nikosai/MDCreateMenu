@echo off
setlocal
cd /d %~dp0
chcp 65001&java MDCreateMenu %1 > "ans.md"&chcp 932