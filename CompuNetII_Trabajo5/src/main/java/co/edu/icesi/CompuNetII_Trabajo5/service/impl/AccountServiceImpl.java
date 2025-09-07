package co.edu.icesi.CompuNetII_Trabajo5.service.impl;

import jakarta.transaction.Transactional;
import co.edu.icesi.CompuNetII_Trabajo5.entity.Account;
import co.edu.icesi.CompuNetII_Trabajo5.repository.AccountRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Marca esta clase como un componente de servicio gestionado por Spring.
@Service
public class AccountServiceImpl implements AccountService {

    // Inyecta el repositorio de cuentas para poder interactuar con la base de datos.
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Implementación de la lógica para transferir dinero.
     */
    @Override
    // --- GESTIÓN DE TRANSACCIONES ---
    // @Transactional es una de las anotaciones más importantes de Spring.
    // Le dice a Spring que todo el código dentro de este método debe ejecutarse dentro de una
    // única transacción de base de datos.
    //
    // ¿Qué significa esto?
    // 1. INICIO: Spring inicia una transacción antes de que el método comience.
    // 2. COMMIT (ÉXITO): Si el método se ejecuta completamente sin lanzar una excepción (específicamente una RuntimeException),
    //    Spring hará un "commit" de la transacción, guardando permanentemente todos los cambios en la base de datos.
    // 3. ROLLBACK (FALLO): Si el método lanza una RuntimeException en cualquier punto, Spring detendrá la ejecución
    //    y hará un "rollback". Esto revierte TODOS los cambios hechos en la base de datos dentro de este método,
    //    dejándola en el estado en que estaba antes de que comenzara la transacción.
    //
    // Esto garantiza la ATOMICIDAD: la transferencia o se hace completa (restar de una cuenta y sumar a la otra) o no se hace nada.
    @Transactional
    public void transferMoney(Long from, Long to, Double amount) {
        // Busca las cuentas de origen y destino en la base de datos.
        // .orElse(null) es una forma simple de manejar el Optional, aunque en un caso real sería mejor lanzar una excepción específica.
        Account accountFrom = accountRepository.findById(from).orElse(null);
        Account accountTo = accountRepository.findById(to).orElse(null);

        // Realiza la primera operación: resta el dinero de la cuenta de origen.
        accountFrom.setBalance(accountFrom.getBalance() - amount);
        // Guarda el cambio en la base de datos. ESTE CAMBIO AÚN NO ES PERMANENTE. Está dentro de la transacción pendiente.
        accountRepository.save(accountFrom);

        // --- SIMULACIÓN DE UN FALLO ---
        // Esta condición está puesta a 'false' para que la transferencia funcione.
        // Si la cambiaras a 'true', se lanzaría una RuntimeException aquí.
        // Gracias a @Transactional, el 'save(accountFrom)' anterior se desharía (rollback) y el balance de
        // la cuenta de origen nunca cambiaría en la base de datos.
        if (false) {
            throw new RuntimeException("Nequi lo ha hecho de nuevo!");
        }

        // Realiza la segunda operación: suma el dinero a la cuenta de destino.
        accountTo.setBalance(accountTo.getBalance() + amount);
        // Guarda el segundo cambio.
        accountRepository.save(accountTo);

        // Si llegamos a este punto sin errores, Spring hará "commit" y ambos cambios se guardarán.
    }
}
