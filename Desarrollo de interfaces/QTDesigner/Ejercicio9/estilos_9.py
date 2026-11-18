#Para que funcione el modulo
#python -m venv App (se añadirá contenido a nuestra carpeta)
#cd App
#cd Scripts
#.\activate
#pip install PyQt6

#Para crear el .ui 
# pyuic6 Ej1.ui -o Ej1.py 

#Para que funcione el designer
# pip install PySide6
# pyside6-designer

#wordgrap para que se ponga un texto en varias linea
#para button crear group box y luego darle checkblea a cada uno

#QT for python
#python
#PyQtIntegration
#errorLens

from typing import Self

from Ejercicio9 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

class MainWindow(QMainWindow,Ui_MainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setupUi(self)
        self.show()
        self.pushButton.pressed.connect(lambda:self.label_4.setStyleSheet("color: red"))
        self.pushButton_2.pressed.connect(lambda:self.label_4.setStyleSheet("color: green"))
        self.pushButton_3.pressed.connect(lambda:self.label_4.setStyleSheet("color: blue"))

        self.pushButton_4.pressed.connect(lambda:self.label_4.setStyleSheet("font-family: Verdana"))
        self.pushButton_5.pressed.connect(lambda:self.label_4.setStyleSheet("font-family: Arial"))
        self.pushButton_6.pressed.connect(lambda:self.label_4.setStyleSheet("font-family: Tahoma"))
 
        self.pushButton_7.pressed.connect(lambda:self.label_4.setStyleSheet("font-size: 10px"))
        self.pushButton_8.pressed.connect(lambda:self.label_4.setStyleSheet("font-size: 12px"))
        self.pushButton_9.pressed.connect(lambda:self.label_4.setStyleSheet("font-size: 15px"))
        
    
app = QApplication([])
app.setStyle("Fusion")
with open("Ejercicio9/Estilos/estilo1.qss","r") as f:
    app.setStyleSheet(f.read())
ventana = MainWindow()
app.exec()