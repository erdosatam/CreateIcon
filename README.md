# CreateIcon
`(c)2020 erdos 0.1.9.0`
>command line tool for creating desktop icons

## Usage

cricon (optiions)

**options:**

	-e <executive (with absolute path)>
	-i <icon (with absolute path)>
	-a Set application for autostart

This application has two outputs. At first if you use it as user the icon (.desktop) file will be created in /home/(user)/.local/share/applications/.
If you use it as root the desktop file will be in /usr/share/applications

The desktop file's name: (choosen name without spaces).desktop

[download](deploy/createicon.deb)
