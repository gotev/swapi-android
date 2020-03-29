package net.gotev.swapi.interfaces

import org.threeten.bp.OffsetDateTime

/**
 * A set of properties which makes a model uniquely identifiable.
 *
 * @property created The ISO 8601 date format of the time that this model was created.
 * @property edited The ISO 8601 date format of the time that this model was edited.
 * @property url The hypermedia URL of this model.
 */
interface Identifiable {
    val created: OffsetDateTime // 2014-12-10T14:23:31.880000Z
    val edited: OffsetDateTime // 2015-04-11T09:46:52.774897Z
    val url: String
}
