from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QDial

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        dial = QDial()
        dial.setRange(-10,10)
        dial.setNotchesVisible(True)

        dial.valueChanged.connect(self.valorCambiado)
        dial.sliderMoved.connect(self.valorCambiado)


        #Mostramos el contenedor por pantalla
        self.setCentralWidget(dial)

    def valorCambiado(self,value):
        print(value)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()