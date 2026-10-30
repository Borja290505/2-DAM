from PyQt6.QtWidgets import QApplication, QComboBox, QDateEdit, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QTextEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QDate, QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("EJERCICIO 3 REPASO") 

    #<===================================================>
        linea1 = QHBoxLayout()
        self.aragon = QRadioButton("Aragon")
        self.cValenciana = QRadioButton("Comunidad valenciana")

        self.aragon.setChecked(True)
        self.aragon.toggled.connect(self.cambiarAragon)
        self.cValenciana.toggled.connect(self.cambiarcValencia)

        linea1.addWidget(self.aragon)
        linea1.addWidget(self.cValenciana)
    #<===================================================>

        self.combo = QComboBox()
        self.combo.addItems(["Teruel","Zaragoza","Huesca"])
    #<===================================================>
        layoutV = QVBoxLayout()
        layoutV.addLayout(linea1)
        layoutV.addWidget(self.combo)

        contenedor = QWidget()
        contenedor.setLayout(layoutV)
        self.setCentralWidget(contenedor)

    def cambiarAragon(self):
        self.combo.clear()
        self.combo.addItems(["Teruel","Zaragoza","Huesca"])

    def cambiarcValencia(self):
        self.combo.clear()
        self.combo.addItems(["Castellon","Alicante","Villa Pijos"])
app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec()