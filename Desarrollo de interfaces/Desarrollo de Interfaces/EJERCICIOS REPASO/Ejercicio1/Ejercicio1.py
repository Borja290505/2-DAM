from PyQt6.QtWidgets import QApplication, QComboBox, QDateEdit, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QTextEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QDate, QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        self.setWindowTitle("EJERCICIO 1 REPASO") 

    #<===================================================>
        nombreHL = QHBoxLayout()

        self.nombre_label = QLabel("Nombre: ")
        self.nombre_lineEdit = QLineEdit()

        nombreHL.addWidget(self.nombre_label)
        nombreHL.addWidget(self.nombre_lineEdit)
    #<===================================================>
        apellidosHL = QHBoxLayout()

        self.apellidos_label = QLabel("Apellidos: ")
        self.apellidos_lineEdit = QLineEdit()
        
        apellidosHL.addWidget(self.apellidos_label)
        apellidosHL.addWidget(self.apellidos_lineEdit)
    #<===================================================>
        fechaHL = QHBoxLayout()
    
        self.fecha_label = QLabel("Fecha: ")
        self.fecha_dateEdit = QDateEdit()

        self.fecha_dateEdit.setCalendarPopup(True)
        self.fecha_dateEdit.setMinimumDate(QDate(2006,1,1))

        fechaHL.addWidget(self.fecha_label)
        fechaHL.addWidget(self.fecha_dateEdit)
    #<===================================================>
        departamentoHL = QHBoxLayout()
        
        self.departamento_label = QLabel("Departamento: ")
        self.departamento_comboBox = QComboBox()
        self.departamento_comboBox.addItems(["Contabilidad","Ventas","Reparto"])

        departamentoHL.addWidget(self.departamento_label)
        departamentoHL.addWidget(self.departamento_comboBox)
    #<===================================================>
        descripcionHL = QHBoxLayout()
                
        self.descripcion_label = QLabel("Descripcion: ")
        self.descripcion_editText = QTextEdit()

        descripcionHL.addWidget(self.descripcion_label)
        descripcionHL.addWidget(self.descripcion_editText)
    #<===================================================>
        botonesAbajo = QHBoxLayout()
    
        self.boton1 = QPushButton("Grabar")
        self.boton2 = QPushButton("Reset")

        self.boton1.pressed.connect(self.escribir)
        self.boton2.pressed.connect(self.reset)

        botonesAbajo.addWidget(self.boton1)
        botonesAbajo.addWidget(self.boton2)
    #<===================================================>
        layoutV = QVBoxLayout()
        layoutV.addLayout(nombreHL)
        layoutV.addLayout(apellidosHL)
        layoutV.addLayout(fechaHL)
        layoutV.addLayout(departamentoHL)
        layoutV.addLayout(descripcionHL)
        layoutV.addLayout(botonesAbajo)

        contenedor = QWidget()
        contenedor.setLayout(layoutV)
        self.setCentralWidget(contenedor)

    def escribir(self):
        self.descripcion_editText.setText(self.nombre_lineEdit.text())
        self.descripcion_editText.append(self.apellidos_lineEdit.text())
        self.descripcion_editText.append(self.fecha_dateEdit.text())
        self.descripcion_editText.append(self.departamento_comboBox.currentText())

    def reset(self):
        self.nombre_lineEdit.clear()
        self.apellidos_lineEdit.clear()
        self.descripcion_editText.clear()
        self.fecha_dateEdit.setDate(QDate(2006,1,1))
        self.departamento_comboBox.setCurrentIndex(0) 



app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec()