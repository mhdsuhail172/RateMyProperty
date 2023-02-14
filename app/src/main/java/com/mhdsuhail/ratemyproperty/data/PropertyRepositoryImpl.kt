package com.mhdsuhail.ratemyproperty.data

import com.mhdsuhail.ratemyproperty.data.room.PropertyDao
import kotlinx.coroutines.flow.Flow

class PropertyRepositoryImpl(private val dao: PropertyDao) : PropertyRepository {
    override suspend fun insertProperty(property: Property) {
        dao.insertProperty(property)
    }

    override suspend fun deleteProperty(property: Property) {
        dao.deleteProperty(property)
    }

    override suspend fun getPropertyById(id: Int): Property? {
        return dao.getPropertyById(id)
    }

    override fun getProperties(): Flow<List<Property>> {
        return dao.getAllProperties()
    }
}