package jooq.airdrone;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in airdrone
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>airdrone.rating_idrating_seq</code>
     */
    public static final Sequence<Long> RATING_IDRATING_SEQ = new SequenceImpl<Long>("rating_idrating_seq", Airdrone.AIRDRONE, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>airdrone.user_iduser_seq</code>
     */
    public static final Sequence<Long> USER_IDUSER_SEQ = new SequenceImpl<Long>("user_iduser_seq", Airdrone.AIRDRONE, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}