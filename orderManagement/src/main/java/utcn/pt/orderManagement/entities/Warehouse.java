package utcn.pt.orderManagement.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Warehouse implements Serializable, Comparable<Warehouse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363430349652448009L;

	@Id
	private int idWarehouse;
	private String warehouseName;
	private String warehouseLocation;
	

	public Warehouse(int idWarehouse, String warehouseName) {
		setIdWarehouse(idWarehouse);
		setWarehouseName(warehouseName);
	}
	

	public int getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}


	public int compareTo(Warehouse warehouse) {
		return getIdWarehouse() - warehouse.getIdWarehouse();
	}


	public String getWarehouseLocation() {
		return warehouseLocation;
	}


	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

}
