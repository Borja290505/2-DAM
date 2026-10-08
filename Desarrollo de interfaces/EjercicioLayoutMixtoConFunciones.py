from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QDoubleSpinBox, QSpinBox, QSlider, QDial, QCalendarWidget, QVBoxLayout, QHBoxLayout
from Color import Color

class MainWindow(QMainWindow): # Asi se crea una clase

    # En caso de para valores decimanles es QDoubleSpinBox
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        plantilla1 = QVBoxLayout(); # Contenedor total
        plantilla2 = QHBoxLayout();
        plantilla3 = QVBoxLayout();
        
        texto = QLabel("Texto");
        self.input = QLineEdit();

        self.checkillo1 = QCheckBox("Opcion 1");
        self.checkillo2 = QCheckBox("Opcion 2");
        self.checkillo3 = QCheckBox("Opcion 3");

        self.checkillo1.setTristate(True) 
        self.checkillo2.setTristate(True)
        self.checkillo3.setTristate(True) 
        
        plantilla1.addLayout(plantilla2)
        plantilla2.addWidget(texto)
        plantilla2.addWidget(self.input)
        plantilla1.addLayout(plantilla3)
        plantilla3.addWidget(self.checkillo1)
        plantilla3.addWidget(self.checkillo2)
        plantilla3.addWidget(self.checkillo3)


        self.input.textChanged.connect(self.textoCambiado)
        self.input.returnPressed.connect(self.textoCambiado)
        self.checkillo1.stateChanged.connect(self.checkMarcado)
        self.checkillo2.stateChanged.connect(self.checkMarcado)
        self.checkillo3.stateChanged.connect(self.checkMarcado)
        
       

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)
      

    def checkMarcado (self, s):
         print(f"{self.sender().text()} {["Desmarcado", "Parcial", "Marcado"][s]}")# 0 es no marcado, 1 es parcialmente marcado (CASI NUNCA VAMOS A VER ESTO EN EL MUNDO REAL), 2 es marcado
        

    def textoCambiado(self):
            print(f"{self.sender().text()}") 
            
    
       
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant