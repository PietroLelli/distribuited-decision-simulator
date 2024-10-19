# Main Simulation
- Simulazione della creazione delle ProductionUnit
    - Aggiunta e rimozione dei Team (formati da Individual)
- Simulazione dell’approvvigionamento di Resources del Warehouse pianificato dal Planner
- Simulazione creazione di Order, composti da ConcreteRecipe, composti da Activity
- Simulazione assegnamento di un’Activity non già eseguito alla waitingList di una ProductionUnit
- Esecuzione di un’Activity presente nella waitingList di una ProductionUnit (se risorse necessarie presenti in magazzino) e quindi creazione del Product risultato dell’Activity
- Simulazione dello spostamento del Product creato dall’Activity (FinalProduct o ByProduct) nel Warehouse
  
# Simulation Output
## Initial state:
**ProductionUnit1 teams:**
- Team1

**ProductionUnit2 teams:**
- Team2

---

### Added Team3 to ProductionUnit1
**ProductionUnit1 teams:**
- Team1
- Team3

**ProductionUnit2 teams:**
- Team2

---

### Removed Team1 from ProductionUnit1
**ProductionUnit1 teams:**
- Team3

**ProductionUnit2 teams:**
- Team2

---

### Added Team1 to ProductionUnit2
**ProductionUnit1 teams:**
- Team3

**ProductionUnit2 teams:**
- Team2
- Team1

---

## Initial Warehouse state:
**Warehouse:** Warehouse1  
**Products:**  
**ByProducts:**  
**Resources:**

---

### Add 5 Resource1 to the Warehouse
### Add 10 Resource2 to the Warehouse

**Warehouse:** Warehouse1  
**Products:**  
**ByProducts:**  
**Resources:**
- Resource1: 5
- Resource2: 10

---

## Order creation: Order1
- **ConcreteRecipe1:**
    - Activity1: TOBEASSIGNED
    - Activity2: TOBEASSIGNED
- **ConcreteRecipe2:**
    - Activity1: TOBEASSIGNED
    - Activity2: TOBEASSIGNED

---

### Assign `getNextActivityToAssign` from ConcreteRecipe1 to the ProductionUnit1 activity waiting list.

### ProductionUnit1 executes `doNextActivityFromWaitingList` and adds the resulting product to the warehouse.

**Order1:**
- **ConcreteRecipe1:**
    - Activity1: COMPLETE
    - Activity2: TOBEASSIGNED
- **ConcreteRecipe2:**
    - Activity1: TOBEASSIGNED
    - Activity2: TOBEASSIGNED

**Warehouse:** Warehouse1  
**Products:**
- FinalProduct1: 1  
**ByProducts:**  
**Resources:**
- Resource1: 4
- Resource2: 10

---

### Assign `getNextActivityToAssign` from ConcreteRecipe1 to the ProductionUnit2 activity waiting list.

### ProductionUnit2 executes `doNextActivityFromWaitingList` and adds the resulting product to the warehouse.

**Order1:**
- **ConcreteRecipe1:**
    - Activity1: COMPLETE
    - Activity2: COMPLETE
- **ConcreteRecipe2:**
    - Activity1: TOBEASSIGNED
    - Activity2: TOBEASSIGNED

**Warehouse:** Warehouse1  
**Products:**
- FinalProduct1: 1  
**ByProducts:**
- ByProduct2: 1  
**Resources:**
- Resource1: 4
- Resource2: 8

---

### Assign `getNextActivityToAssign` from ConcreteRecipe2 to the ProductionUnit2 activity waiting list.

### ProductionUnit2 executes `doNextActivityFromWaitingList` and adds the resulting product to the warehouse.

**Order1:**
- **ConcreteRecipe1:**
    - Activity1: COMPLETE
    - Activity2: COMPLETE
- **ConcreteRecipe2:**
    - Activity1: COMPLETE
    - Activity2: TOBEASSIGNED

**Warehouse:** Warehouse1  
**Products:**
- FinalProduct1: 2  
**ByProducts:**
- ByProduct2: 1  
**Resources:**
- Resource1: 3
- Resource2: 8

---

### Assign `getNextActivityToAssign` from ConcreteRecipe2 to the ProductionUnit2 activity waiting list.

### ProductionUnit2 executes `doNextActivityFromWaitingList` and adds the resulting product to the warehouse.

**Order1:**
- **ConcreteRecipe1:**
    - Activity1: COMPLETE
    - Activity2: COMPLETE
- **ConcreteRecipe2:**
    - Activity1: COMPLETE
    - Activity2: COMPLETE

**Warehouse:** Warehouse1  
**Products:**
- FinalProduct1: 2  
**ByProducts:**
- ByProduct2: 2  
**Resources:**
- Resource1: 3
- Resource2: 6
