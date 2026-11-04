from PyQt6.QtWidgets import QCalendarWidget, QDoubleSpinBox, QGridLayout, QMainWindow, QDateEdit, QComboBox, QHBoxLayout, QRadioButton, QSpinBox, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QGroupBox
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate 

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My App")

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")

        botonAccion = QAction(QIcon("icons/bug.png"),"Accion",self)
        botonAccion.setStatusTip("Pulsa para ejecutar la accion") 
        menu_archivo.addAction(botonAccion)

        barra = QToolBar()
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)

        self.setStatusBar(QStatusBar(self))
        barra.addAction(botonAccion)

        #<============================================>
        plantilla1 = QHBoxLayout(); # Contenedor total
        plantilla2 = QHBoxLayout();

        self.texto = QLabel("Elemento a añadir")
        self.lineEdit = QLineEdit()
        self.botonAnadir = QPushButton("Añadir")
        self.botonAnadir.pressed.connect(self.aniadirTexto)
        self.comboEj1 = QComboBox()
        self.botonBorrar = QPushButton("Borrar todo")
        self.botonBorrar.pressed.connect(self.borrarCombo)


        grupo1 = QGroupBox("Ejercicio 1")
        grupo1.setLayout(plantilla2)

        plantilla1.addWidget(grupo1)
        plantilla2.addWidget(self.texto)
        plantilla2.addWidget(self.lineEdit)
        plantilla2.addWidget(self.botonAnadir)
        plantilla2.addWidget(self.comboEj1)
        plantilla2.addWidget(self.botonBorrar)

        #<===================================================>

        #<============================================>
        plantillaHorizontal3 = QHBoxLayout(); # Contenedor total
        plantillaEj3 = QGridLayout();

        self.opcionA = QRadioButton("A")
        self.opcionA.pressed.connect(self.aniadirTexto)
        self.opcionB = QRadioButton("B")
        self.opcionC = QRadioButton("C")

        self.opcion1 = QCheckBox("1")
        self.opcion2 = QCheckBox("2")
        self.opcion3 = QCheckBox("3")

        self.texto2 = QTextEdit()

        plantillaEj3.addWidget(self.opcionA,0,0)
        self.opcionA.pressed.connect(self.marcarLetraA)
        plantillaEj3.addWidget(self.opcion1,0,1)

        plantillaEj3.addWidget(self.opcionB,1,0)
        self.opcionB.pressed.connect(self.marcarLetraB)
        plantillaEj3.addWidget(self.opcion2,1,1)

        plantillaEj3.addWidget(self.opcionC,2,0)
        self.opcionC.pressed.connect(self.marcarLetraC)
        plantillaEj3.addWidget(self.opcion3,2,1)

        plantillaHorizontal3.addLayout(plantillaEj3)
        plantillaHorizontal3.addWidget(self.texto2)
        #<============================================>
        tabs = QTabWidget()
        #<============================================>

        fechaHL = QHBoxLayout()
        self.fecha_dateEdit = QDateEdit()   
        self.fecha_dateEdit.setCalendarPopup(True)
        self.fecha_dateEdit.setMinimumDate(QDate(2010,1,1)) 
        self.editCalendar = QLineEdit()
        self.fecha_dateEdit.dateChanged.connect(self.valorcambiado)
    

        fechaHL.addWidget(self.fecha_dateEdit)
        fechaHL.addWidget(self.editCalendar)

        #<============================================>
        spinHl = QHBoxLayout()
        self.spinbox = QDoubleSpinBox()
        self.spinbox.setRange(0, 100)
        self.spinbox.setSingleStep(0.5)
        self.spinbox.textChanged.connect(self.valorcambiadoSpin)
        self.lineEditSpin = QLineEdit()

        spinHl.addWidget(self.spinbox)
        spinHl.addWidget(self.lineEditSpin)

        #<============================================>

        widget1 = QWidget()
        widget2 = QWidget()

        widget1.setLayout(fechaHL)
        widget2.setLayout(spinHl)

        tabs.addTab(widget1,"Pestaña 1")
        tabs.addTab(widget2,"Pestaña 2")

        layoutPrincipal = QVBoxLayout()
        layoutPrincipal.addLayout(plantilla1)
        layoutPrincipal.addLayout(plantillaHorizontal3)
        layoutPrincipal.addWidget(tabs)

        #<============================================>

        contenedor = QWidget()
        contenedor.setLayout(layoutPrincipal)
        self.setCentralWidget(contenedor)
        
    def aniadirTexto(self):
        self.comboEj1.addItem(self.lineEdit.text())

    def borrarCombo(self):
        self.comboEj1.clear()

    def marcarLetraA(self):
        self.texto2.append(self.opcionA.text())
    def marcarLetraB(self):
        self.texto2.append(self.opcionB.text())
    def marcarLetraC(self):
        self.texto2.append(self.opcionC.text())

    def valorcambiado(self):
        self.editCalendar.setText(self.fecha_dateEdit.text())

    def valorcambiadoSpin(self):
        self.lineEditSpin.setText(self.spinbox.text())


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
