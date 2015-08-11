echo off

if %date:~,3%==Sat goto :WeekEnd
if %date:~,3%==Sun goto :WeekEnd

:WeekDay
xcopy /f /y "%~dp0BusinessDays\logo.jpg" "%~dp0Target\logo.jpg*"
goto :eof

:WeekEnd
xcopy /f /y "%~dp0Weekend\logo.jpg" "%~dp0Target\logo.jpg*"
goto :eof