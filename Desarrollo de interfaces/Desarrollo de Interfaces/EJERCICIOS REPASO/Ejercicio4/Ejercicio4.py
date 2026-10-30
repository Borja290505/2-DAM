from PyQt6.QtWidgets import QApplication, QComboBox, QDateEdit, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QTextEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QDate, QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("EJERCICIO 4 REPASO") 
    #<===================================================>

        layoutPrincipal = QVBoxLayout()
        self.total = 0
    #<===================================================>
        self.texto = QLabel()
        self.texto.setAlignment(Qt.AlignmentFlag.AlignRight)

        layoutPrincipal.addWidget(self.texto)
    #<===================================================>
        layoutH1 = QHBoxLayout()
        layoutH2 = QHBoxLayout()
        layoutH3 = QHBoxLayout()           
        layoutH4 = QHBoxLayout()
        layoutH5 = QHBoxLayout()
    #<===================================================>
        botonSuma = QPushButton("+")
        botonSuma.pressed.connect(self.sumar)
        layoutH4.addWidget(botonSuma)
    #<===================================================>
        for i in range(0,10):
            self.boton = QPushButton(str(i))
            self.boton.pressed.connect(self.escribir)

            if i>=7:
                layoutH1.addWidget(self.boton)
            elif i >=4:
                layoutH2.addWidget(self.boton)
            elif i>=1:
                layoutH3.addWidget(self.boton)
            else:
                layoutH4.addWidget(self.boton)

    #<===================================================>

        botonIgual = QPushButton("=")
        botonIgual.pressed.connect(self.igual)
        layoutH4.addWidget(botonIgual)
    #<===================================================>
        botonCE = QPushButton("CE")
        botonCE.pressed.connect(self.ce)
        layoutH5.addWidget(botonCE)
    #<===================================================>

        layoutPrincipal.addLayout(layoutH1)
        layoutPrincipal.addLayout(layoutH2)
        layoutPrincipal.addLayout(layoutH3)
        layoutPrincipal.addLayout(layoutH4)
        layoutPrincipal.addLayout(layoutH5)

        widget = QWidget()
        widget.setLayout(layoutPrincipal)
        self.setCentralWidget(widget)

    def escribir(self):
        #El .sender() se refiere al boton que lo ha activado
        self.texto.setText(self.texto.text()+self.sender().text())

    def ce(self):
        self.texto.clear()
        self.total=0

    def sumar(self):
        if self.texto.text() != "":
            self.total = int(self.texto.text())
            self.texto.clear()

    def igual(self):
        if self.texto.text() != "":
            self.texto.setText(str(int(self.texto.text()) + self.total))
            self.total = int(self.texto.text())
        
app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec()