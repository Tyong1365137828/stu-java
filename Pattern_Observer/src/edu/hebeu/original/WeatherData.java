package edu.hebeu.original;

/**
 * 1. �������µ����������Ϣ
 * 2. ���� CurrentConditions ����
 * 3.  �������и���ʱ���������ĵ���	CurrentConditions ���� update ����(�� display),  ������
 * �ǣ����뷽���Ϳ������µ���Ϣ
 * @author 13651
 *
 */
public class WeatherData {
	
	private float temperatrue; // �¶�
	private float pressure; // ��ѹ
	private float humidity;// ʪ��
	
	//�����µĵ�����
	private CurrentConditions currentConditions;

	public WeatherData(CurrentConditions currentConditions) {
		this.currentConditions = currentConditions;
	}

	/**
	 * ��ȡ�¶�
	 * @return
	 */
	public float getTemperature() {
		return temperatrue;
	}

	/**
	 * ��ȡ��ѹ
	 * @return
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * ��ȡʪ��
	 * @return
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * �����ݸı�ʱ���õĺ���
	 */
	public void dataChange() {
		//���� ���뷽�� update
		currentConditions.update(getTemperature(), getPressure(), getHumidity());
	}

	/**
	 * �������и���ʱ�����õĺ���
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure; this.humidity = humidity;
		//���� dataChange�� �����µ���Ϣ ���͸� ���뷽 currentConditions
		dataChange();
	}

}
