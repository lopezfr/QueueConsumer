package com.so1.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by carloscubur on 15/11/17.
 */
public class Transaccion implements Serializable{
    private int idTransaccion;
    private int idUsuario;
    private int idCoin;
    private int idPlatformOrigin;
    private int idPlatformDestiny;
    private int idProduct;
    private BigDecimal Mount;
    private int Quantity;

    public Transaccion() {
    }

    public Transaccion(int idTransaccion, int idUsuario, int idCoin, int idPlatformOrigin, int idPlatformDestiny, int idProduct, BigDecimal mount, int quantity) {
        this.idTransaccion = idTransaccion;
        this.idUsuario = idUsuario;
        this.idCoin = idCoin;
        this.idPlatformOrigin = idPlatformOrigin;
        this.idPlatformDestiny = idPlatformDestiny;
        this.idProduct = idProduct;
        Mount = mount;
        Quantity = quantity;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public void setIdCoin(int idCoin) {
        this.idCoin = idCoin;
    }

    public int getIdPlatformOrigin() {
        return idPlatformOrigin;
    }

    public void setIdPlatformOrigin(int idPlatformOrigin) {
        this.idPlatformOrigin = idPlatformOrigin;
    }

    public int getIdPlatformDestiny() {
        return idPlatformDestiny;
    }

    public void setIdPlatformDestiny(int idPlatformDestiny) {
        this.idPlatformDestiny = idPlatformDestiny;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getMount() {
        return Mount;
    }

    public void setMount(BigDecimal mount) {
        Mount = mount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
