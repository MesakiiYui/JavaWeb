
@echo off
set target_path=C:\soft\.ivy2
set copy_target_path=C:\soft\ivySum
set jarfile=*.jar
C:
cd %target_path%
for /f "delims=" %%s in ('dir /b/a-d/s "%target_path%"\"%jarfile%"') do (
echo %%s
copy /y "%%s" %copy_target_path%
)
pause
