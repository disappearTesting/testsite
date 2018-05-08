WinWait("File Upload", "", 5)

ControlFocus("[CLASS:#32770]","", "Edit1")

Sleep(3000)

ControlSetText("[CLASS:#32770]", "", "Edit1", "C:\Users\Makarov_K\IdeaProjects\testsite\AutoIT\test.txt")

Sleep(3000)

ControlClick("[CLASS:#32770]", "", "Button1")