package co.edu.icesi.CompuNetII_Trabajo5.service;

// La interfaz para el servicio de gestión de cuentas bancarias.
// Define el contrato para las operaciones de negocio relacionadas con las cuentas.
public interface IAccountService {

    /**
     * Define la operación de negocio para transferir dinero entre dos cuentas.
     * Esta es una operación "transaccional": o se completan todos los pasos, o no se hace ninguno.
     * @param from el ID de la cuenta de origen.
     * @param to el ID de la cuenta de destino.
     * @param amount la cantidad de dinero a transferir.
     */
    void transferMoney(Long from, Long to, Double amount);

}
