WinWait("File Upload", "", 5)

ControlFocus("[CLASS:#32770]","", "Edit1")

ControlSetText("[CLASS:#32770]", "", "Edit1", "C:\Users\Makarov_K\IdeaProjects\testsite\testsite_resources\filePage\fileToUpload.txt")

ControlClick("[CLASS:#32770]", "", "Button1")