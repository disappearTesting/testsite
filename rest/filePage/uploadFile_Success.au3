WinWait("File Upload", "", 5)

ControlFocus("[CLASS:#32770]","", "Edit1")

Sleep(3000)

ControlSetText("[CLASS:#32770]", "", "Edit1", "C:\Users\hookie\IdeaProjects\testsite\rest\filePage\fileToUpload.txt")

Sleep(3000)

ControlClick("[CLASS:#32770]", "", "Button1")