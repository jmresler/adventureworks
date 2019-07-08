/**
 * 
 */
package org.jmresler.spring.aw.support;

import javax.persistence.AttributeConverter;

import com.microsoft.sqlserver.jdbc.Geography;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * @author John
 *
 */
public class GeographyConverter implements AttributeConverter<Byte[], Geography> {

	@Override
	public Geography convertToDatabaseColumn(Byte[] attribute) {
		Geography geography = null;
		try {
			byte[] buf = new byte[attribute.length];
			System.arraycopy(attribute, 0, buf, 0, attribute.length);
			geography = Geography.STGeomFromWKB(buf);
		} catch (SQLServerException e) {
			e.printStackTrace();
		}
		return geography;
	}

	@Override
	public Byte[] convertToEntityAttribute(Geography geography) {
		byte[] bytes = geography.serialize();
		Byte[] geoBytes = new Byte[bytes.length];
		System.arraycopy(bytes, 0, geoBytes, 0, geoBytes.length);
		return geoBytes;
	}

}
