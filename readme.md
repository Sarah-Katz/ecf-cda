# **ECF - API** | _Concepteur Développeur d'Applications_

## Contexte du projet

Dans le cadre de notre formation, nous sommes évalués sur les compétences acquise.<br>
Ce projet se concentre sur les activités types 2 et 3 (CP 6 à 15) du <a href="https://www.banque.di.afpa.fr/EspaceEmployeursCandidatsActeurs/Download.aspx?i=2c26e04d-00c6-42f7-b832-05f3e436a716&d=1">REAC CDA de 2018</a>.

Il nous ai demandé de réaliser une application de gestion du séjour des patients dans un hôpital, le but est de pouvoir :

-   Ajouter un nouveau patient
-   Modifier des patients existants.
-   Prendre en compte l’arrivée d’un patient dans un service.
-   Prendre en compte la sortie d’un service.

Un patient, lors d’un séjour, est affecté à un lit qui est lui-même dans une chambre.

Les tâches sont donc :

-   Mettre en place des outils d'organisation de notre travail
-   Conception MERISE
-   Conception UML (à minima, le diagramme de Use Case et le diagramme de classes)
-   Création de la base de données
-   Développement de la partie back-end
-   Développement d'au moins un test unitaire et un test d'intégration
-   Mise en place d'une architecture multi-couches
-   Les requêtes SQL suivantes :<br>
    _Afficher les noms et prénoms de tous les patients affectés au service "Urgences"_<br>
    _Afficher tous les lits actuellement libres_

---

## Installer le projet

-   Cloner le repository
-   Executer <code>docker compose up</code> à la racine du projet
-   Lancer l'application Spring dans le dossier **./api**

---

## Endpoints de l'API

### **Patients**

-   **_POST_** | **"/patients"** - Création d'un patient.
-   **_GET_** | **"/patients"** - Récupération de tous les patients de l'hôpital.
-   **_GET_** | **"/patients/$id"** - Récupération d'un patient par son id.
-   **_PUT_** | **"/patients"** - Modification d'un patient.
-   **_DELETE_** | **"/patients/$id"** - Suppression d'un patient par son id.
-   **_POST_** | **"/patients/assign/$id"** - Assignation d'un patient à un service par l'id su service.
-   **_POST_** | **"/patients/unassign/"** - Retrait d'un patient à un service.

### **Bed**

-   **_GET_** | **"/beds"** - Récupération de tous les lits de l'hôpital.
-   **_GET_** | **"/beds/byPatient/$id"** - Récupération du lit assigné à un patient par l'id du patient.

### **Room**

-   **_GET_** | **"/rooms/byPatient/$id"** - Récupération de la chambre assignée à un patient par l'id du patient.
-   **_GET_** | **"/beds/byService/$id"** - Récupération de la liste des chambres d'un service par l'id du service.
-   **_GET_** | **"/rooms/beds/$id"** - Récupération de la liste des lits libres des chambres d'un service par l'id du service.
-   **_POST_** | **"/rooms/addBed/"** - Assigne un lit libre à une chambre.
-   **_POST_** | **"/rooms/removeBed/"** - libère un lit libre d'une chambre et l'ajoute aux lits libres.

### **Service**

-   **_GET_** | **"/patients"** - Récupération de tous les services de l'hôpital.

---

### _Technologies utilisées_

![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![POSTGRESQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![DOCKER](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![TRELLO](https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=trello&logoColor=white)
![GIT](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)

---

## **Authors**

👤 **_Sarah Katz_**

<a href="https://github.com/Sarah-Katz"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></img></a>
<a href="https://www.linkedin.com/in/sarah-katz-dev/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></img></a>
