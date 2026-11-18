#Para que funcione el modulo
#python -m venv App (se añadirá contenido a nuestra carpeta)
#cd App
#cd Scripts
#.\activate
#pip install PyQt6
# pyuic6 Ej1.ui -o Ej1.py 

#Para que funcione el designer
# pip install PySide6
# pyside6-designer

from Ejercicio3 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

class MainWindow(QMainWindow,Ui_MainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setupUi(self)
        self.show()

app = QApplication([])
app.setStyle("Fusion")
with open("Ejercicio3/Estilos/estilo3.qss","r") as f:
    app.setStyleSheet(f.read())
ventana = MainWindow()
app.exec()